package sample.services;


import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import sample.exceptions.UsernameAlreadyExistsException;
import sample.users.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javafx.collections.ObservableList;


import static sample.services.FileSistemService.getPathToFile;

public class UserService {



    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {

        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("SkiLessonsApp.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role,"","",""));
    }

    public static void getInstructors(ObservableList<String> names){
        try{
            for (User user : userRepository.find()){
                if(Objects.equals("Instructor",user.getRole())){
                    names.add(user.getUsername());

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void getPrices(ObservableList<String> prices){
        try{
            for (User user : userRepository.find()){
                if(Objects.equals("Instructor",user.getRole())){
                    prices.add(user.getPrice()+" ron");

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String returnsDescription(String name){
        for(User user: userRepository.find()){
            if(Objects.equals(user.getUsername(),name)){
                return user.getDescription();
            }
        }
        return null;
    }
    public static String returnsPrice(String name){
        for(User user: userRepository.find()){
            if(Objects.equals(user.getUsername(),name)){
                return user.getPrice();
            }
        }
        return null;
    }
    public static String returnsMountain(String name){
        for(User user: userRepository.find()){
            if(Objects.equals(user.getUsername(),name)){
                return user.getMountain();
            }
        }
        return null;
    }


    public static int validateLogin(String username, String password) {
        for (User user : userRepository.find()) {
            if(Objects.equals(username, user.getUsername()))
            {
                String pass=encodePassword(username,password);

            if (Objects.equals(user.getPassword(),pass))
            {
                if(Objects.equals(user.getRole(),"Instructor")){
                    return 1;

                }
                if(Objects.equals(user.getRole(),"Client")){
                    return 2;
                }
            }
           }
        }
        return 0;

    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static int modifyUserInfo(String name, String password, String p, String d, String m){
        for (User user : userRepository.find()){
            if(Objects.equals(name,user.getUsername()))
            {
                String pass=encodePassword(name,password);
                if(Objects.equals(pass,user.getPassword()))
                {
                    //user.setUsername(name);
                    //user.setPassword(pass);
                    user.setPrice(p);
                    user.setMountain(m);
                    user.setDescription(d);
                    userRepository.update(user);
                    return 1;

                }

            }
        }return 0;

    }



    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }





}
