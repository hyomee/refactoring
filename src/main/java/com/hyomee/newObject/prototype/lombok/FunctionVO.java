package com.hyomee.newObject.prototype.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
public class FunctionVO   {
    private String functionId;
    private String functionName;

    public static List<FunctionVO> deepCopyList(List<FunctionVO> sourceFuncs) {
        return sourceFuncs.stream().map(FunctionVO::deepCopy).collect(Collectors.toList());

    }

    private static FunctionVO deepCopy(FunctionVO sourceFunc) {
        return sourceFunc.toBuilder().build();

    }

}
