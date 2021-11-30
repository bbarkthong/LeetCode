/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ret = 0;

        Map<Integer, Employee> db;
        db = new HashMap<Integer, Employee>();

        for (Employee emp : employees) {
            System.out.println(emp.id);
            db.put(emp.id, emp);
        }
        return calImportance(db, id);
    }

    public int calImportance(Map<Integer, Employee> db, int id) {
        int ret = 0;

        Employee emp = db.get(id);
        if (emp != null) {
            ret += emp.importance;
            for (int subId : emp.subordinates) {
                ret += calImportance(db, subId);
            }
        }
        return ret;
    }
}
