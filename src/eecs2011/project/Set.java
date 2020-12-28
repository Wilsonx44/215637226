package eecs2011.project;

public class Set {
    Vertices[] known;
    int size;

    public Set(int allSize){
        this.size = allSize;
        this.known = new Vertices[allSize];
    }

    public boolean contains(Vertices v){
        if (known[v.functionName] == null){
            return false;
        } else {
            return true;
        }
    }

    public void puts(Vertices v){
        known[v.functionName] = v;
    }

    public String toString(){
        String answer = "";

        for (int i = 0; i < known.length; i++){
            System.out.println(known[i].functionName);
        }

        return answer;
    }

    public boolean noVoid(){
        for (int i = 0; i < known.length; i++){
            if (known[i] == null){
                return false;
            }
        }
        return true;
    }

    public Vertices gets(Vertices v){
        return known[v.functionName];
    }

}
