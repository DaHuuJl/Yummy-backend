package com.yummy.restful.util;

import com.yummy.restful.model.User;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

@Component
public class JWT {
    private final List<String> tokens = new LinkedList<>();
    private Cipher cipher;

    public JWT() {
        try {
            this.cipher = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec("ldkfj329jsd0kssdkf23".getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }


    public String createToken(User user) {
        String token = "";
        try {
            byte[] bytes = cipher.doFinal((user.getId() + " " + user.getPhoneNumber() + " " + user.getFullName()).getBytes());
            tokens.add(token);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return token;
    }

    public boolean checkToken(String token) {
        for(String str : tokens) {
            if (str.equals(token))
                return true;
        }
        return false;
    }

    public void deleteToken(String token) {
        for(int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals(token)) {
                tokens.remove(i);
                break;
            }
        }
    }
}