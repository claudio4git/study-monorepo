package br.com.jccf.apachecamel.bean;

public class SampleBean {

    public String map(String value) {
        return value.replaceAll(",", "*");
    }
}
