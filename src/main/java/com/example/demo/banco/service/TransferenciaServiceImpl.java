package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepo;
import com.example.demo.banco.repository.TransferrenciaRepo;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service()
public class TransferenciaServiceImpl implements TransferenciaService{

	
	@Autowired
	private TransferrenciaRepo trasferrenciaRepo;
	@Autowired
	private CuentaRepo cuentaRepo;
	@Autowired
	@Qualifier("internacional")
	private MontoDebitarService debitarService;
	
	@Autowired
	private Impuesto impuesto;
	
	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		System.out.println("la trasferencia sev calcula con el iva");
		System.out.println(impuesto.getIva());
		this.trasferrenciaRepo.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.trasferrenciaRepo.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.trasferrenciaRepo.eliminar(numero);
	}

	@Override
	public Transferencia buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.trasferrenciaRepo.seleccionarNumero(numero);
	}

	@Override
	public void realizar(String numCuentaOrigen, String numCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//1. consultar la cuenta de origen por el numero de cuenta
		Cuenta ctaOrigen= cuentaRepo.seleccionarNumero(numCuentaOrigen);
		// 2.  consultar el saldo de la cuanta de origen
		
		BigDecimal saldoOrigen= ctaOrigen.getSaldo();
		BigDecimal montoDebitar= this.debitarService.calcular(monto);
		//3. validar si el saldo es suficiente
		if(monto.compareTo(saldoOrigen)<=0) {
			
			
			//5. si es suficiente ir al paso 6	
			//6. realizar la resta del saldo origen- monto
			BigDecimal nuevoSaldoOrigen=saldoOrigen.subtract(montoDebitar);
			
			//7. actualizar el nuevo saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepo.actualizar(ctaOrigen);
			//8. consultamos la cuenta de destino por el numero
			Cuenta ctaDestino= cuentaRepo.seleccionarNumero(numCuentaDestino);

			//9. consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino= ctaDestino.getSaldo();
			//10. realizamos la suma del saldo destiono+ monto
			BigDecimal nuevoSaldoDestino=saldoDestino.add(monto);
			//11. actualizamos el nuevo saldo de la cuenta destino
		ctaDestino.setSaldo(nuevoSaldoDestino);
		this.cuentaRepo.actualizar(ctaDestino);

			//12.  creamos la transferencia 
		Transferencia  transfer= new Transferencia();
		transfer.setCuentaOrigen(ctaOrigen);
		transfer.setCuentaDestino(ctaDestino);
		transfer.setMonto(monto);
		Double numero= Math.random();
		transfer.setNumero(numero.toString());
		transfer.setFecha(LocalDateTime.now());
		this.trasferrenciaRepo.insertar(transfer);
		
		}else {
			// 4. si no es suficiente imprimir mensaje de que no hay saldo

			System.out.println("Su saldo no disponible, su saldo es: "+ saldoOrigen);
		}
		
		

		
	}

	@Override
	public List<Transferencia> estadoCuenta() {
		// TODO Auto-generated method stub
		return this.trasferrenciaRepo.estadoCuenta();
	}

}
