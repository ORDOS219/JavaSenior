package com.atguigu.team.service;

import static com.atguigu.team.service.Data.*;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee的方法
 * @author yangyang Email:ordos219@gmail.com
 * @version v1.0
 * @data Oct 31, 20208:17:16 PM
 */

public class NameListService {

	private Employee[] employees;// 存放员工信息

	public NameListService() {

		employees = new Employee[Data.EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {
			// 获取员工的基本信息
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			// 获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;

			switch (type) {
			case Data.EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;

			case Data.PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;

			case Data.DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;

			case Data.ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}

	/**
	 * 
	 * @Description 获取指定index上的员工的设备
	 * @author yangyang
	 * @data Oct 31, 20209:24:12 PM
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int index) {

		int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		String modelOrName = EQUIPMENTS[index][1];

		switch (key) {
		case PC:// 21
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName, display);

		case NOTEBOOK:// 22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);

		case PRINTER:// 23
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		}
		return null;
	}

	/**
	 * 
	 * @Description 获取当前所有员工
	 * @author yangyang
	 * @data Nov 1, 202010:32:54 AM
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}

	/**
	 * 
	 * @Description 获取当前指定员工
	 * @author yangyang
	 * @data Nov 1, 202010:33:29 AM
	 * @param id
	 * @return
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定员工！");
	}
}
