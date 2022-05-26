package entities;

public class Usuario {
String name;
String pin;
double saldoCC, saldoCA;
public String getName() {
		return name;
	}
public void setName(String name) {
		this.name = name;
	}
public String getPin() {
		return pin;
	}
public void setPin(String pin) {
		this.pin = pin;
		}

public double getSaldoCC() {
	return saldoCC;
}
public void setSaldoCC(double saldoCC) {
	this.saldoCC = saldoCC;
}
public double getSaldoCA() {
	return saldoCA;
}
public void setSaldoCA(double saldoCA) {
	this.saldoCA = saldoCA;
}
public Usuario(String name, String pin) {
	super();
	this.name = name;
	this.pin = pin;
}
public Usuario() {}
public void mostrarDatos() {
	System.out.println(this.getName()	+"	"+this.getPin());
	
}

}
