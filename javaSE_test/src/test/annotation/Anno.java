package test.annotation;

@FirstAnno("http://hrmzone.cn")   
public class Anno {   
@Kitto("测试")   
private String test = "";   
//  不赋值注释中的参数，使用默认参数   
    @SecondAnnotation()   
    public String getDefault() {   
            return "get default Annotation";   
    }   
    @SecondAnnotation(name="desktophrm",url="desktophrm.com")   
    public String getDefine() {   
            return "get define Annotation";   
    }   
  
}   