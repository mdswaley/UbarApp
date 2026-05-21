package com.mdswaley.project.uber.uberApp.configs;

import com.mdswaley.project.uber.uberApp.dto.PointDto;
import com.mdswaley.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // You cannot directly expose Point in request/response JSON because it's a complex geometry object.

        // Convert PointDto received from API request into Point object
        // Point is used as a spatial type for storing geographic locations in database
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
            PointDto pointDto = context.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        // Convert Point object back into PointDto before sending API response
        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();

            // Extract longitude (X) and latitude (Y) from Point
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };

            // Return coordinates as DTO object
            return new PointDto(coordinates);
        });

        return mapper;
    }
}
