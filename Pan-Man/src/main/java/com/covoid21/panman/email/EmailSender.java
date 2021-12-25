package com.covoid21.panman.email;

public interface EmailSender {
    /**
     *
     * @param to
     * @param email
     */
    void send(String to, String email);
}
