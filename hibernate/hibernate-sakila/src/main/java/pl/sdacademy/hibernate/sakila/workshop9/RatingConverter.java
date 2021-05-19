package pl.sdacademy.hibernate.sakila.workshop9;

import javax.persistence.AttributeConverter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RatingConverter implements AttributeConverter<Rating,String> {
    private static final Map<String,Rating> codeToRating = Stream.of(Rating.values())
            .collect(Collectors.toMap(Rating::getCode, Function.identity()));

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        return attribute.getCode();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        return codeToRating.get(dbData);
    }
}
