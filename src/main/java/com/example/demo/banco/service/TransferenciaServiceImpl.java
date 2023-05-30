package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepo;
import com.example.demo.banco.repository.TrasferrenciaRepo;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Trasferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	
	@Autowired
	private TrasferrenciaRepo trasferrenciaRepo;
	@Autowired
	private CuentaRepo cuentaRepo;
	@Override
	public void guardar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		this.trasferrenciaRepo.insertar(transferencia);
	}

	@Override
	public void actualizar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		this.trasferrenciaRepo.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.trasferrenciaRepo.eliminar(numero);
	}

	@Override
	public Trasferencia buscarNumero(String numero) {
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
		//3. validar si el saldo es suficiente
		if(monto.compareTo(saldoOrigen)<=0) {
			
			
			//5. si es suficiente ir al paso 6	
			//6. realizar la resta del saldo origen- monto
			BigDecimal nuevoSaldoOrigen=saldoOrigen.subtract(monto);
			
			//7. actualizar el nuevo saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepo.actualizar(ctaOrigen);
			//8. consultamos la cuenta de destino por el numero
			Cuenta ctaDestino= cuentaRepo.seleccionarNumero(numCuentaOrigen);

			//9. consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino= ctaDestino.getSaldo();
			//10. realizamos la suma del saldo destiono+ monto
			BigDecimal nuevoSaldoDestino=saldoDestino.add(monto);
			//11. actualizamos el nuevo saldo de la cuenta destino
		ctaDestino.setSaldo(nuevoSaldoDestino);
		this.cuentaRepo.actualizar(ctaDestino);

			//12.  creamos la transferencia 
		Trasferencia  transfer= new Trasferencia();
		transfer.setCuentaOrigen(ctaOrigen);
		transfer.setCuentaDestino(ctaDestino);
		transfer.setMonto(monto);
		Double numero= Math.random();
		transfer.setNumero(numero.toString());
		transfer.setFecha(LocalDateTime.now());
		this.trasferrenciaRepo.insertar(transfer);
		
		}else {
			// 4. si no es suficiente imprimir mensaje de que no hay saldo

			System.out.println("Su saldo no disponible, suxcsaldo es: "+ saldoOrigen);
		}
		
		

		
	}

}
