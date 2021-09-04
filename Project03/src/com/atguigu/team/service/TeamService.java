package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * 
 * @Description 关于开发团队成员的管理：添加、删除等
 * @author yangyang Email:ordos219@gmail.com
 * @version
 * @data Nov 1, 20203:08:11 PM
 */
public class TeamService {
	private static int counter = 1;// 给memberId赋值使用
	private final int MAX_MEMBER = 5;// 限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发团队成员
	private int total = 0;// 记录开发团队中实际的人数

	public TeamService() {
		super();
	}
	/**
	 * 
	 * @Description 获取开发团队中的所有成员
	 * @author yangyang
	 * @data Nov 1, 20203:18:57 PM
	 * @return
	 */
	//返回team中所有程序员构成的数组
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < total; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 
	 * @Description 将指定的员工添加到开发团队中
	 * @author yangyang
	 * @data Nov 1, 20203:19:18 PM
	 * @param e
	 */
	public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		Programmer p = (Programmer)e;// 一定不会出现强转异常
//		该员工已在本开发团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员
		//自定义枚举类的方法：getNAME()
/*		if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		}else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加");
		}//		该员正在休假，无法添加*/
		//enum定义的枚举类：通过抛出异常输出
		switch (p.getStatus()){
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOVATION:
				throw new TeamException("该员正在休假，无法添加");
		}

		
//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员
		int numOfArc = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if(team[i] instanceof Architect) {
				numOfArc++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
			if (p instanceof Architect) {
				if (numOfArc >= 1) {
					throw new TeamException("团队中至多只能有一名架构师");
				}
			} else if (p instanceof Designer) {
				if (numOfDes >= 2)
					throw new TeamException("团队中至多只能有两名设计师");
			} else if (p instanceof Programmer) {
				if (numOfPro >= 3)
					throw new TeamException("团队中至多只能有三名程序员");
			}

			team[total++] = p;// 将p(或e)添加到team中
			p.setStatus(Status.BUSY);
			p.setMemberId(counter++);// 设置memberId
		

	}
	/**
	 * 
	 * @Description 判断指定员工是否已经存在于现有的开发团队中
	 * @author yangyang
	 * @data Nov 1, 20203:55:00 PM
	 * @param e
	 * @return
	 */
	public boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @Description 从团队当中删除成员
	 * @author yangyang
	 * @data Nov 1, 20203:19:22 PM
	 * @param memberId
	 */
	public void removeMember(int memberId) throws TeamException{
		int i = 0;
		for (; i < total; i++) {
			if (team[i].getId() == memberId) {
				team[i].setStatus(Status.FREE);
				
				for (int j = i + 1; j < total; j++) {
					team[j - 1] = team[j];
				}
				// 将最后一个元素置空并将total-1
				// 方法一
				team[total - 1] = null;
				total--;
				//方法二
//				team[--total] = null; 
				break;
			}else if(i == total) {
				throw new TeamException("找不到指定memberId的员工，删除失败！");
			}
		}
/*		if(i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败！");
		}
*/	
/*		// 后一个元素覆盖前一个元素
		for (int j = i + 1; j < total - 1; j++) {
			team[j] = team[j + 1];
		}
		// 将最后一个元素置空并将total-1
		// 方法一
		team[total - 1] = null;
		total--;
		//方法二
		//team[--total] = null; 
*/
	}
}
