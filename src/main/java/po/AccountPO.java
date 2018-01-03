package po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Account")
public class AccountPO implements Serializable{
	//created by peng
	String date;
	Set<GoodsPO> GoodsList = new HashSet<>();
	Set<BankPO> BankList = new HashSet<>();
	Set<MemberPO> MemberList = new HashSet<>();//会员列表

	public AccountPO() {
	}

	public AccountPO(Set<GoodsPO> goodsList, Set<BankPO> bankList, Set<MemberPO> memberList, String date) {
		this.date = date;
		GoodsList = goodsList;
		BankList = bankList;
		MemberList = memberList;
	}

@Id
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
@OneToMany(cascade = CascadeType.MERGE)
	public Set<GoodsPO> getGoodsList() {
		return GoodsList;
	}

	public void setGoodsList(Set<GoodsPO> goodsList) {
		GoodsList = goodsList;
	}
	@OneToMany(cascade = CascadeType.MERGE)
	public Set<BankPO> getBankList() {
		return BankList;
	}

	public void setBankList(Set<BankPO> bankList) {
		BankList = bankList;
	}
	@OneToMany(cascade = CascadeType.MERGE)
	public Set<MemberPO> getMemberList() {
		return MemberList;
	}

	public void setMemberList(Set<MemberPO> memberList) {
		MemberList = memberList;
	}
}







