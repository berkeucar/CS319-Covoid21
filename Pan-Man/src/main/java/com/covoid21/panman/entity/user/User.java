package com.covoid21.panman.entity.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.build.Plugin;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

// @Table(name = "user_table")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public abstract class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String username;
    private String password;


    private String email;
    private String hesCode;
    private InfectionStatus infectionStatus;
    private boolean fullyVaccinated;
    /*private ArrayList<Integer> closeContactsID;
    private ArrayList<Integer> appointmentsID;
    private ArrayList<Integer> notificationsID;
    private ArrayList<Integer> temporaryCloseContactsID;
    private ArrayList<VaccinationEntry> vaccinationsEntries;
    private ArrayList<TestEntry> testEntries;*/



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
