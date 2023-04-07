package org.example;

import java.util.List;

public class ListCommand implements Command{

    private Catalog catalog;
    public ListCommand(Catalog c)
    {
       this.catalog = c;
    }

    public void execute(){

        final StringBuffer sb = new StringBuffer("Catalog{");
        sb.append("name='").append(this.catalog.getName()).append('\'');
        sb.append(", docs=").append(this.catalog.getDocs());
        sb.append('}');
        System.out.println(sb);
    }


}
