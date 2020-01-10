package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.RegisterUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Address;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.util.AddressBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegisterUserUseCaseImple implements RegisterUserUseCase {
    @Override
    public Long Register() {
        Session mySession = HibernateUtil.getSession();
        Scanner input=new Scanner(System.in);
        mySession.beginTransaction();
        System.out.println("Enter Username:");
        String username = input.next();
        System.out.println("Enter National Code:");
        String nCode = input.next();
        System.out.println("Enter birthday!");
        String birth = input.next();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        Date birthday=null;
        try {
            birthday =format.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Address> addresses = new ArrayList<>();
        System.out.println("Enter your address information:");
        System.out.println("Enter provience:");
        String provience = input.next();
        System.out.println("Enter city:");
        String city = input.next();
        System.out.println("Enter street:");
        String street = input.next();
        System.out.println("Enter postCode:");
        String postCode = input.next();
        AddressBuilder addressBuilder = new AddressBuilder();
        Address address = addressBuilder
                .provience(provience)
                .city(city)
                .street(street)
                .postCode(postCode)
                .build();
        addresses.add(address);
        User user = new User(username,nCode,nCode,birthday);
        Long id = (Long)  mySession.save(user);
        address.setUser(user);
        user.setAddresses(addresses);
        mySession.update(user);
        mySession.getTransaction().commit();
        return id;
    }
}
