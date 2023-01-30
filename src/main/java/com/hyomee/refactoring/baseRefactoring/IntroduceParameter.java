package com.hyomee.refactoring.baseRefactoring;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class IntroduceParameter {

    public void IntroduceParameter(TemperatureVO pTemperatureVO) {

        final List<TemperaturePolicyVO> temperaturePolicyVOs = List.of(
                TemperaturePolicyVO.builder().temp(70).FanStrength("4단계").build(),
                TemperaturePolicyVO.builder().temp(50).FanStrength("3단계").build(),
                TemperaturePolicyVO.builder().temp(30).FanStrength("2단계").build(),
                TemperaturePolicyVO.builder().temp(10).FanStrength("1단계").build()
        );

        List<TemperaturePolicyVO> temperaturePolicyVOList = getTemperaturePolicyVO(temperaturePolicyVOs, pTemperatureVO.getMin(), pTemperatureVO.getMax());
        log.debug("온도범위 :" + temperaturePolicyVOList.toString());

        List<TemperaturePolicyVO> introdUceTemperaturePolicyVOList = getTemperaturePolicyVO(temperaturePolicyVOs, pTemperatureVO);
        log.debug("온도범위 선택된온도범위객체 :" + introdUceTemperaturePolicyVOList.toString());

    }


    private List<TemperaturePolicyVO> getTemperaturePolicyVO(List<TemperaturePolicyVO> temperaturePolicyVOs,
                                             int pMin,
                                             int pMax) {

        return temperaturePolicyVOs.stream()
                .filter(temperaturePolicyVO -> !( pMin > temperaturePolicyVO.getTemp() ||
                                                  pMax < temperaturePolicyVO.getTemp()) )
                .collect(Collectors.toList());


    }

    private List<TemperaturePolicyVO> getTemperaturePolicyVO(List<TemperaturePolicyVO> pTemperaturePolicyVOs,
                                                    TemperatureVO pTemperatureVO ) {

        return pTemperaturePolicyVOs.stream()
                .filter(TemperaturePolicyVO -> !( pTemperatureVO.getMin() > TemperaturePolicyVO.temp ||
                                                  pTemperatureVO.getMax() < TemperaturePolicyVO.temp) )
                .collect(Collectors.toList());


    }
}


@Getter
@Setter
@Builder
@ToString
class TemperaturePolicyVO {
    int temp;
    String FanStrength;
}

@Getter
@Setter
@Builder
@ToString
class TemperatureVO {
    int min;
    int max;
}