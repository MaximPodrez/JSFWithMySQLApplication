import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MyBean {

    private String name;
    private DBConnection dbc = new DBConnection();
    private List<Player> list = new ArrayList<>();
    
    public MyBean() {
    }
    
    public List<Player> getList() {
        list = dbc.getList();
        return list;
    }

    public void setList(List<Player> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String display()
    {
        return "display";
    }
}
