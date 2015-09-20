package br.com.carloseduardo.spring.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geladeiras")
@XmlAccessorType (XmlAccessType.FIELD)
public class Geladeiras {
	@XmlElement
    private List<Geladeira> geladeiras = null;
 
    public List<Geladeira> getGeladeiras() {
        return geladeiras;
    }
 
    public void setGeladeiras(List<Geladeira> geladeiras) {
        this.geladeiras = geladeiras;
    }
}
