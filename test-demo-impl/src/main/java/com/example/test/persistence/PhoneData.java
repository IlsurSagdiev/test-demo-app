package com.example.test.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "phone_data")
public class PhoneData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_data_id_gen")
    @SequenceGenerator(name = "phone_data_id_gen", sequenceName = "seq_phone_data_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "phone", length = 13)
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneData)) return false;
        PhoneData phoneData = (PhoneData) o;
        return Objects.equals(user, phoneData.user.getName()) &&
                Objects.equals(phone, phoneData.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getName(), phone);
    }
}