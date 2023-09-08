package com.ballys.movierental.rental;

import com.ballys.movierental.movie.MovieMapper;
import com.ballys.movierental.web.MovieRentalException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalService {

    private final RentalMapper rentalMapper;
    private final MovieMapper movieMapper;

    @Transactional(readOnly = true)
    public Collection<RentalView> findRentalsByUserId(Long userId) {
        return rentalMapper.selectByUserId(userId);
    }

    @Transactional(propagation = Propagation.NEVER)
    @SneakyThrows
    public void saveRental(Rental rental) {
        try {
            movieMapper.exclusiveLock();
            Integer quantity = movieMapper.selectQuantity(rental.getMovieId());
            if(quantity == null || quantity < 1) {
                throw new MovieRentalException("Movie is unavailable");
            }
            rentalMapper.insert(rental);
            movieMapper.updateQuantity(rental.getMovieId(), quantity - 1);
            movieMapper.commitTransaction();
        }catch (Exception e) {
            movieMapper.rollbackTransaction();
            throw e;
        }
    }

}
