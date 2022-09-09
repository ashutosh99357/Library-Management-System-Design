package searcher;

import java.util.List;

import User.Member;

public class IdBasedMemberSearcher implements MemberSearcher {

	private final int id;
	
	public IdBasedMemberSearcher(int id)
	{
		this.id=id;
	}
	@Override
	public List<Member> search() {
		// TODO Auto-generated method stub
		return null;
	}

}
