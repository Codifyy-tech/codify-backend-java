package tech.codifyy.services;

import tech.codifyy.beans.Trilha;

public class Informacoes {
    private InfoUsuario userInfo;
    private Trilha courses_registered;

    public Informacoes() {
    }

    public Informacoes(InfoUsuario userInfo, Trilha courses_registered) {
        this.userInfo = userInfo;
        this.courses_registered = courses_registered;
    }

    public InfoUsuario getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(InfoUsuario userInfo) {
        this.userInfo = userInfo;
    }

    public Trilha getCourses_registered() {
        return courses_registered;
    }

    public void setCourses_registered(Trilha courses_registered) {
        this.courses_registered = courses_registered;
    }
}
