package sample;

public class Member {

    public int memberId, noBooksIssued, maxBookLimit;

    public String type, dateOfMember, name, address;

    public long ph_no;

    public Member(int memberId, String type, String dateOfMember, int noBooksIssued, int maxBookLimit, String name, String address, long ph_no){
        this.memberId = memberId;
        this.type = type;
        this.dateOfMember = dateOfMember;
        this.noBooksIssued = noBooksIssued;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.ph_no = ph_no;
    }

    public Member retrieveMember(Member member){
        return member;
    }

    public void addMember(){

    }

    public void deleteMember(){

    }

    public void updateMember(){

    }

    public void payFine(Fine fine){

    }

    public void issueBook(Book book){

    }

    public void returnBook(Book book){

    }

    public int getMemberId(){
        return memberId;
    }

}
