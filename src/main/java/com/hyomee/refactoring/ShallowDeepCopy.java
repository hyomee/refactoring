package com.hyomee.refactoring;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import org.springframework.stereotype.Service;

@Service
public class ShallowDeepCopy {

    @SneakyThrows(JsonProcessingException.class)
    public void ObjectCopy()  {
        서비스요소VO 서비스요소VO_01 = new 서비스요소VO();

        서비스요소VO_01.set이벤트코드("ACT");
        서비스요소VO_01.set요소코드("FTR000001");
        서비스요소VO_01.set파라메터("F00=001002");

        서비스요소VO 서비스요소VO_shallow= 서비스요소VO_01;
        서비스요소VO_shallow.set파라메터("F00=001003");
        boolean is서비스요소VO_shallow = 서비스요소VO_01.equals(서비스요소VO_shallow);
        System.out.println("is서비스요소VO_shallow : " + is서비스요소VO_shallow);

        서비스요소VO 서비스요소VO_Cloneable = 서비스요소VO_01.서비스요소복재();
        서비스요소VO_Cloneable.set파라메터("F00=001004");
        boolean is서비스요소VO_Cloneable = 서비스요소VO_01.equals(서비스요소VO_Cloneable);
        System.out.println("is서비스요소VO_Cloneable : " + is서비스요소VO_Cloneable);


        서비스요소VO 서비스요소VO_Constructor= new 서비스요소VO(서비스요소VO_01);
        서비스요소VO_Constructor.set파라메터("F00=001004");
        boolean is서비스요소VO_Constructor = 서비스요소VO_01.equals(서비스요소VO_Constructor);
        System.out.println("is서비스요소VO_Constructor : " + is서비스요소VO_Constructor);

        서비스요소VO 서비스요소VO_Factory = 서비스요소VO.서비스요소VOFactory(서비스요소VO_01);
        서비스요소VO_Factory.set파라메터("F00=001004");
        boolean is서비스요소VO_Factory = 서비스요소VO_01.equals(서비스요소VO_Factory);
        System.out.println("is서비스요소VO_Factory : " + is서비스요소VO_Factory);

        서비스요소VO 서비스요소VO_Lombok = 서비스요소VO_01.toBuilder().build();
        서비스요소VO_Lombok.set파라메터("F00=001004");
        boolean is서비스요소VO_Lombok= 서비스요소VO_01.equals(서비스요소VO_Lombok);
        System.out.println("is서비스요소VO_Lombok : " + is서비스요소VO_Lombok);

        ObjectMapper objectMapper = new ObjectMapper();
        서비스요소VO 서비스요소VO_ObjectMapper = objectMapper.readValue(objectMapper.writeValueAsString(서비스요소VO_01), 서비스요소VO.class);
        서비스요소VO_ObjectMapper.set파라메터("F00=001004");boolean is서비스요소VO_ObjectMapper = 서비스요소VO_01.equals(서비스요소VO_ObjectMapper);
        System.out.println("is서비스요소VO_ObjectMapper : " + is서비스요소VO_ObjectMapper);



        System.out.println("Rmx");
    }


    public void MapStructCopy() {
        SvcFtrVO svcFtrVO = SvcFtrVO.builder()
                .이벤트코드("ACT")
                .요소코드("FTR000001")
                .파라메터("F00=001003")
                .build();

        SvcFtrVO svcFtrVO_01 = CopyMapper.copyMapper.toSvcFtrVO(svcFtrVO);
        svcFtrVO_01.set파라메터("F00=001004");
        boolean issvcFtrVO_01 = svcFtrVO.equals(svcFtrVO_01);
        System.out.println("is서비스요소VO_MapStruct : " + issvcFtrVO_01);

        System.out.println("Rmx");
    }

}





@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class 서비스요소VO implements Cloneable {
    private String 이벤트코드;
    private String 요소코드;
    private String 파라메터;


    public  서비스요소VO(서비스요소VO p서비스요소VO)  {
        this.이벤트코드 = p서비스요소VO.get이벤트코드();
        this.요소코드 = p서비스요소VO.get요소코드();
        this.파라메터 = p서비스요소VO.get파라메터();
    }

    public static 서비스요소VO 서비스요소VOFactory(서비스요소VO p서비스요소VO)  {
        return new 서비스요소VO(p서비스요소VO);
    }

    public  서비스요소VO 서비스요소복재()  {
        try {
            return (서비스요소VO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
