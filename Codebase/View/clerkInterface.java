public void issueBooks() {
        Member member;
        Book book;

        String memberID = getToken("Enter  membership id");
        member = library.searchMembership(memberID);
        do {
            String bookID = getToken("Enter  book id");
            book = library.issueBook(bookID, member.getId());

            System.out.println("Successful Checkout Transaction for book " + book.getTitle() + " due " + book.getDate());

            if (!yesOrNo("Issue more books?")) {
                break;
            }
        } while (true);
    }
