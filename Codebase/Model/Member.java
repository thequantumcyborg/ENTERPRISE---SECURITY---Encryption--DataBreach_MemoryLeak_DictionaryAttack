public String generateEncryptedObjectReference(){
       String saltedObject=saltKey+toString();
       String md5 = null;
      try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(saltedObject.getBytes(), 0, saltedObject.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
      
      return md5;
  }
  
  public String toString() {
    String string = "Member name " + name + " address " + address + " id " + id + " phone " + phone;
    return string;
  }
