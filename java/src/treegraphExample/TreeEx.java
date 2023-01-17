package treegraphExample;

import java.util.ArrayList;

public class TreeEx {

    private String value;
    private ArrayList<TreeEx> children; // 나의 자식 노드 연결.

    public TreeEx() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public TreeEx(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }
    public void addChildNode(TreeEx node) {
        if(children==null) children = new ArrayList<>(); // 새로운 걸 만든ㄷ ㅏ..? 그럼 없어야지;
        children.add(node);
    }
    public void removeChildNode(TreeEx node) {
        String data = node.getValue();

        if(children != null) { // 자식노드가 존재한다면.
            for(int i = 0; i < children.size(); i++) { // 자식노드들의 모든 노드들을 검색해서
                if(children.get(i).getValue().equals(data)) { // 갖고잇는 데이터라면.
                    children.remove(i); // 해당 자식 노드를.삭제.노드를!!! 데이터가 아니라.,
                    return;
                }
                if(children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<TreeEx> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        boolean check;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, false);
                if(check) return true;
            }
        }
        return false;
    }

    public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, check);
            }
        }
        return check;
    }

}
