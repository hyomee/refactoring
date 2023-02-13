package com.hyomee.refactoring.replaceControlFlagwithBreak;

import org.springframework.stereotype.Service;

@Service
public class ReplaceControlFlagWithBreak {
    public void 조건탈출() {
        boolean isBreak = false;
        for ( int i = 0; i < 100; i++) {
            if ( i == 40 ) {
                isBreak = true;
            }
        }
    }

    public void 조건탈출Break() {

        for ( int i = 0; i < 100; i++) {
            if ( i == 40 ) {
                break;
            }
        }
    }

}
