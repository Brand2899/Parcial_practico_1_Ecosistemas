package com.parcial_practico_1;

public class Command {

    private boolean delete;

    public Command(boolean delete){
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
