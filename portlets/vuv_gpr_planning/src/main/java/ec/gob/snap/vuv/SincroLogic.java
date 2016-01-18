
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import ec.gob.administracionpublica.wsGPRServices.Indicator;
import ec.gob.administracionpublica.wsGPRServices.InstitutionalActivity;
import ec.gob.administracionpublica.wsGPRServices.Service;
import ec.gob.administracionpublica.wsGPRServices.ServiceCase;
import ec.gob.administracionpublica.wsGPRServices.ServiceCaseStep;
import ec.gob.administracionpublica.wsGPRServices.ServiceCenterExtended;
import ec.gob.administracionpublica.wsGPRServices.ServiceCharter;
import ec.gob.administracionpublica.wsGPRServices.ServiceInOperation;
import ec.gob.administracionpublica.wsGPRServices.ServiceOfficeInfo;
import ec.gob.administracionpublica.wsGPRServices.ServiceRequisite;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Class with the logic to sincronize with the GPR.</p>
 * <b>Project:</b><p>vuv</p>
 * 
 * @version 1.0, 28/5/2015.
 */
public final class SincroLogic {

	/**
	 * Constructor method for the class {@link SincroLogic}.
	 */
	private SincroLogic() {

	}
	/**
	 * Attribute that represents the log.
	 */
	private static Log log = LogFactoryUtil.getLog(SincroLogic.class);

	/**
	 * Main method to sincronize with GPR.
	 */
	public static void sincronize() {

		GPRInterface gpr =
			new GPRInterface(
				PropsUtil.get("gpr.user"), PropsUtil.get("gpr.pass"),
				PropsUtil.get("gpr.address"));
		if (gpr.isUp()) {
			log.info("GPR is up");
			log.info("Checking folders");
			LiferayPersistence.folderCheck();
			log.info("Folders checked");

			log.info("Starting content sincronization");

			List<ServiceOfficeInfo> instituciones = gpr.getGprEntitesList();
			List<String> activeInstituciones = new ArrayList<String>();
			if (instituciones != null) {
				log.info(instituciones.size() + " institutions fetched");
				for (ServiceOfficeInfo institucion : instituciones) {
					if (institucion != null) {
						log.info("Processing institution " +
							institucion.getId());
						ServiceCharter serviceCharter =
							gpr.getServiceCharter(institucion.getId());
						if (LiferayPersistence.isNewInstitucion(institucion)) {
							LiferayPersistence.createInstitucion(
								institucion, serviceCharter);
						}
						else {
							LiferayPersistence.updateInstitucion(
								institucion, serviceCharter);
							LiferayPersistence.activateInstitution(institucion.getId());
						}
						activeInstituciones.add(institucion.getId());
					}
				}
				log.info("Expiring inactive institutions");
				int instituciones_expired =
					LiferayPersistence.expireInactiveInstitutions(activeInstituciones);
				log.info(instituciones_expired + " institutions expired");
			}

			List<ServiceInOperation> servicios =
				gpr.getServicesInOperationList();
			List<String> activeServicios = new ArrayList<String>();
			if (servicios != null) {
				log.info(servicios.size() + " services fetched");
				for (ServiceInOperation servicioOperative : servicios) {
					if (servicioOperative != null) {
						String id_institucion =
							servicioOperative.getEntidadId();
						String id_servicio = servicioOperative.getServiceId();
						Service servicio = gpr.getService(id_servicio);
						log.info("Processing service " + id_servicio);
						if (servicio != null) {
							if (LiferayPersistence.isNewServicio(servicio)) {
								LiferayPersistence.createServicio(
									servicio, id_institucion);

								Indicator[] indicadores =
									servicio.getIndicators();
								if (indicadores != null) {
									for (Indicator indicador : indicadores) {
										if (indicador != null) {
											LiferayPersistence.createIndicador(
												indicador, id_servicio);
										}
									}
								}

								InstitutionalActivity[] actInsts =
									servicio.getInstitutionalActivities();
								if (actInsts != null) {
									for (InstitutionalActivity actividad : actInsts) {
										if (actividad != null) {
											LiferayPersistence.createActividadInstitucional(
												actividad, id_servicio);
										}
									}
								}

								ServiceCase[] casos = servicio.getCases();
								if (casos != null) {
									for (ServiceCase caso : casos) {
										if (caso != null) {

											String id_caso = caso.getId();
											LiferayPersistence.createCaso(
												caso, id_servicio);

											ServiceCenterExtended[] centros =
												caso.getUpsExt();
											if (centros != null) {
												for (ServiceCenterExtended centro : centros) {
													if (centro != null) {
														LiferayPersistence.createCentro(
															centro, id_caso);
													}
												}
											}

											ServiceCaseStep[] pasos =
												caso.getSteps();
											if (pasos != null) {
												for (ServiceCaseStep paso : pasos) {
													if (paso != null) {
														String id_paso =
															paso.getId();
														LiferayPersistence.createPaso(
															paso, id_caso);

														ServiceRequisite[] requisitos =
															paso.getRequisites();
														if (requisitos != null) {
															for (ServiceRequisite requisito : requisitos) {
																if (requisito != null) {
																	LiferayPersistence.createRequisito(
																		requisito,
																		id_paso);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
							else {
								boolean updated =
									LiferayPersistence.updateServicio(servicio);
								if (updated) {
									LiferayPersistence.activateServicio(id_servicio);
									Indicator[] indicadores =
										servicio.getIndicators();
									if (indicadores != null) {
										for (Indicator indicador : indicadores) {
											if (indicador != null) {
												if (LiferayPersistence.isNewIndicador(indicador)) {
													LiferayPersistence.createIndicador(
														indicador, id_servicio);
												}
												else {
													LiferayPersistence.updateIndicador(indicador);
													LiferayPersistence.activateIndicador(indicador.getUid_indicator());
												}
											}
										}
									}

									InstitutionalActivity[] actInsts =
										servicio.getInstitutionalActivities();
									if (actInsts != null) {
										for (InstitutionalActivity actividad : actInsts) {
											if (actividad != null) {
												if (LiferayPersistence.isNewActividadInstitucional(actividad)) {
													LiferayPersistence.createActividadInstitucional(
														actividad, id_servicio);
												}
												else {
													LiferayPersistence.updateActividadInstitucional(actividad);
													LiferayPersistence.activateActividadInstitucional(actividad.getId());
												}
											}
										}
									}

									ServiceCase[] casos = servicio.getCases();
									if (casos != null) {
										for (ServiceCase caso : casos) {
											if (caso != null) {
												String id_caso = caso.getId();
												LiferayPersistence.createCaso(
													caso, id_servicio);

												ServiceCenterExtended[] centros =
													caso.getUpsExt();
												if (casos != null) {
													for (ServiceCenterExtended centro : centros) {
														if (centro != null) {
															if (LiferayPersistence.isNewCentro(centro)) {
																LiferayPersistence.createCentro(
																	centro,
																	id_caso);
															}
															else {
																LiferayPersistence.updateCentro(centro);
																LiferayPersistence.activateCentro(centro.getId());
															}
														}
													}
												}

												ServiceCaseStep[] pasos =
													caso.getSteps();
												if (pasos != null) {
													for (ServiceCaseStep paso : pasos) {
														if (paso != null) {
															String id_paso =
																paso.getId();
															if (LiferayPersistence.isNewPaso(paso)) {
																LiferayPersistence.createPaso(
																	paso,
																	id_caso);
															}
															else {
																LiferayPersistence.updatePaso(paso);
																LiferayPersistence.activatePaso(paso.getId());
															}
															ServiceRequisite[] requisitos =
																paso.getRequisites();
															if (requisitos != null) {
																for (ServiceRequisite requisito : requisitos) {
																	if (requisito != null) {
																		if (LiferayPersistence.isNewRequisito(requisito)) {
																			LiferayPersistence.createRequisito(
																				requisito,
																				id_paso);
																		}
																		else {
																			LiferayPersistence.updateRequisito(requisito);
																			LiferayPersistence.activateRequisito(requisito.getId());
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
						activeServicios.add(servicio.getId());
					}
				}
				log.info("Expiring inactive services");
				int servicios_expired =
					LiferayPersistence.expireInactiveServicios(activeServicios);
				log.info(servicios_expired + " services expired");
			}
			log.info("END");
		}
		else {
			log.warn("Impossible to contact GPR");
		}
	}
}
