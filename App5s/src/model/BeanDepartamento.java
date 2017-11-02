package model;

public class BeanDepartamento {
String nome;
String dataCriado;
String idUsuario;
int id;
double total;

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public BeanDepartamento() {

}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDataCriado() {
	return dataCriado;
}
public void setDataCriado(String dataCriado) {
	this.dataCriado = dataCriado;
}
public String getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(String idUsuario) {
	this.idUsuario = idUsuario;
}

}
