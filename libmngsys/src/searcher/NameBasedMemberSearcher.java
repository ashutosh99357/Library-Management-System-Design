package searcher;

import java.util.List;

import User.Member;
import dataaccessor.DBAccessor;
import dataaccessor.Results;
import dataaccessor.ResultsConvertor;

public class NameBasedMemberSearcher implements MemberSearcher {

	private final String memberName;
	private final DBAccessor dbAccessor;
	public NameBasedMemberSearcher(String memberName)
	{
		this.memberName = memberName;
		this.dbAccessor=new DBAccessor();
	}
	@Override
	public List<Member> search() {
		// TODO Auto-generated method stub
		Results results = dbAccessor.getMembersWithName(memberName);
		return ResultsConvertor.convertToMembers(results);
	}

}
