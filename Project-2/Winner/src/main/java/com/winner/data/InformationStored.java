package com.winner.data;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformationStored {

    private Integer WinnerId;

   private  Map<Integer , Integer> ticket = new HashMap<>();
}
