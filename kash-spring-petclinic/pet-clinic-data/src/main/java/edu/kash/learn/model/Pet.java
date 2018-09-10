package edu.kash.learn.model;

import edu.kash.learn.model.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "type_id")
    PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;
    String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    Set<Visit> visitSet = new HashSet<>();

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }
}
