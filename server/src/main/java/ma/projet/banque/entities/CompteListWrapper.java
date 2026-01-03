package ma.projet.banque.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "List")
public class CompteListWrapper {
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<Compte> item;
    
    public CompteListWrapper() {}
    
    public CompteListWrapper(List<Compte> comptes) {
        this.item = comptes;
    }
    
    public List<Compte> getItem() {
        return item;
    }
    
    public void setItem(List<Compte> item) {
        this.item = item;
    }
}

