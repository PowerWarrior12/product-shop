package org.example.services.mappers;

import org.example.domain.Offer;
import org.example.dto.offer.ShortOfferDto;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    public ShortOfferDto offerToShortOfferDto(Offer offer) {
        return new ShortOfferDto(
                offer.getNewPrice(),
                offer.isAvailable()
        );
    }
}
