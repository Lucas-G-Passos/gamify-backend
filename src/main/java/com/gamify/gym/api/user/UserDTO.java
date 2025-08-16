package com.gamify.gym.api.user;

public class UserDTO {
    private String name;
    private String password;
    private String userType; // nutricionista, player, personal
    private String crn;
    private String cref;
    private String cpf;
    private Double height;
    private Double weight;
    private long personalTrainerId;
    private long nutritionistId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public long getPersonalTrainerId() {
        return personalTrainerId;
    }

    public void setPersonalTrainerId(long personalTrainerId) {
        this.personalTrainerId = personalTrainerId;
    }

    public long getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(long nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

}
