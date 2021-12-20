package com.example.feedbackmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "kitchen")
@NoArgsConstructor
public class Feedback {
    @Id
    @SequenceGenerator(name = "feedback-sequence", sequenceName = "feedback_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "feedback-sequence")
    private Long id;

    @ApiModelProperty("Айди юзера")
    private Long userId;

    @ApiModelProperty("Текст отзыва")
    private String message;

    @Min(0)
    @Max(5)
    private Double rate;

    @CreatedDate
    @ApiModelProperty("Дата создания")
    private LocalDateTime dateTime;
}
