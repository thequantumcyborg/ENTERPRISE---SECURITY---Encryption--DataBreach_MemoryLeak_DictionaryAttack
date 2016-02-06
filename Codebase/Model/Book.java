private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String id;
    private String date;
    private String checkedOutBy;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.date = "Available";
        this.checkedOutBy = "N/A";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(String saltedMember) {
        checkedOutBy = saltedMember;
    }

    public void setDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 30);
        this.date = sdf.format(c.getTime());
    }

    public boolean issue(String saltedMember) {
        boolean isIssued = false;

        setCheckedOutBy(saltedMember);
        isIssued = true;

        return isIssued;
    }

    private String unmaskThisMember(String memberKey) {
        String partialMemberInfo = "N/A";
        if (memberKey.isEmpty()) {
            partialMemberInfo = "N/A";
        } else if (memberKey.equals("N/A")) {
            //do nothing  
        } else {
            
            partialMemberInfo = MemberList.instance().getSessionDatabase(memberKey);
        }

        return partialMemberInfo;
    }

    public String toString() {
        return "title " + title + " , author " + author + " , id " + id + " , Due date/Status : " + date + " , Checkedout by : " + unmaskThisMember(checkedOutBy);

    }
