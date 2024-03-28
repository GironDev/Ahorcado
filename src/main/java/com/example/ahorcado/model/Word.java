package com.example.ahorcado.model;

public class Word {
    private String wordSecret;

    public Word(String wordSecret){
        this.wordSecret = wordSecret;
    }

    public String getWordSecret() {
        return wordSecret;
    }

    public void setWordSecret(String wordSecret) {
        this.wordSecret = wordSecret;
    }
}
