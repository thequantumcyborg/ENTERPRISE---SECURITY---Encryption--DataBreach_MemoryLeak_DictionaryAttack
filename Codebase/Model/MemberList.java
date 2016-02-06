    private static final long serialVersionUID = 1L;
    private List members = new LinkedList();
    private static MemberList memberList;
    private Member member;
    private static Library library;
    private HashMap<String, Member> sessionDatabase = new HashMap<String, Member>();


    private MemberList() {
    }

    public static MemberList instance() {
        if (memberList == null) {
            return (memberList = new MemberList());
        } else {
            return memberList;
        }
    }

    public boolean insertMember(Member member) {
        members.add(member);
        return true;
    }

    public Iterator getMembers() {
        return members.iterator();
    }
    
    protected String getSessionDatabase(String memberAutenticationKey) {
         
       
      Member maskedMember=sessionDatabase.get(memberAutenticationKey);
      String partialMemberInfo=maskedMember.getName()+" , Phone: "+maskedMember.getPhone();
        
      return partialMemberInfo;
    }
    
     //sessionDatabase used for encryption purposes
    public boolean sessionDatabase(String saltedKey, Member member){
        boolean inMemory=false;
         
          sessionDatabase.put(saltedKey, member);
          inMemory=true;
          
          
        return inMemory;
        
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
    
