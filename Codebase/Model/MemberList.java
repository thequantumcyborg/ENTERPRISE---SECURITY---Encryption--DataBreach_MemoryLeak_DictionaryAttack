public boolean insertMember(Member member) {
        members.add(member);
        return true;
    }

    public Iterator getMembers() {
        return members.iterator();
    }

    public Member search(String memberID) {
        Iterator allmembers = MemberList.instance().getMembers();
        while (allmembers.hasNext()) {
            Member memberInstance = (Member) allmembers.next();
            if (memberInstance.getId().equals(memberID)) {
                this.member = memberInstance;
               
                break;
            }

        }
   
        return member;
    }
    
    //sessionDatabase used for encryption purposes
    public boolean sessionDatabase(String saltedKey, Member member){
        boolean inMemory=false;
         HashMap hm = new HashMap();
         
          hm.put(saltedKey, member);
          inMemory=true;
          
          
        return inMemory;
        
    }
