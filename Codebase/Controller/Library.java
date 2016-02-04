public Book issueBook(String bookID,String memberID){
         boolean bookToMemberLinker=false;
         boolean memberToBookLinker=false;
         
         if (bookID==null) {
            throw new NullPointerException("Service Connnection interruption, please search again. Error Log >[Log Rule]");
        }
         if (bookID.equals("")) {
            throw new IllegalArgumentException("Please enter book id.");
        }
        
         
        Book book = catalog.search(bookID);
       
        if (book==null) {
            throw new NullPointerException("Service Connnection interruption, please search again. Error Log >[Log Rule]");
        }
        
        //search for existing account
        Member member = memberList.search(memberID);
        
         if (member == null) {
            throw new NullPointerException("Service Connnection interruption, please search again. Error Log >[Log Rule]");
        }

        //Objectslinker
        bookToMemberLinker=member.issue(book.toString());
                
        //Objectslinker
        //activate encryption agaist dictionary attack
        String sensitiveData= member.generateEncryptedObjectReference();
        memberToBookLinker=book.issue(sensitiveData);
        book.setDate();
        
        //store member object & salted member object reference to session database
        memberList.sessionDatabase(sensitiveData,member);
        
        //flushing variable to avoid memory leak of sensitiveData 
        sensitiveData=null;
        
        //for incomplete transaction 
        if(!memberToBookLinker && !bookToMemberLinker){
            book=null;
            throw new NullPointerException("Service Connnection interruption, please issue again. Error Log >[Log Rule]");
        
        }
        return book;
    }
