package com.hyomee.refactoring.baseRefactoring;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EncapsulateVariable {

    public void 고객생성(String p이름, int p나이) {
        String 이름 = "김김동";
        int 나이 = 20;

        // 기본 고객 정보를 유지 하기 위해서 어떻게 .....

        이름 = StringUtils.isNotEmpty(p이름) ? p이름 : 이름 ;
        나이 = p나이 > 0 ? p나이 : 나이;

        고잭저장(  이름,  나이);



    }

    public void 고객생성캡슐화(String p이름, int p나이) {

        고객VO 기본고객정보 = new 고객VO();
        고객VO 고개정보 = new 고객VO(p이름, p나이);

        고잭저장(  기본고객정보.get이름(),  기본고객정보.get나이());
        고잭저장(  고개정보.get이름(),  고개정보.get나이());

        log.debug(기본고객정보.equals(고개정보) ? "참" : "거짓");

        // 고객 정보와 기본고객정보는 틀림 - 이후 다른 객체로 작업 가능
    }

    private void 고잭저장( String 이름, int 나이) {
        log.debug(String.format("이름 %s, 나이 %d", 이름, 나이));
    }
}

@Getter
@NoArgsConstructor
class 고객VO {
    private String 이름 = "김김동";
    private int 나이 = 20;

    고객VO(String p이름, int p나이) {

        this.이름 = StringUtils.isNotEmpty(p이름) ? p이름 : 이름 ;
        this.나이 = p나이 > 0 ? p나이 : 나이;
    }



}
