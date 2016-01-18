package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ec.gob.snap.vuv.model.Servicio;

/**
 * The persistence interface for the servicio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServicioPersistenceImpl
 * @see ServicioUtil
 * @generated
 */
public interface ServicioPersistence extends BasePersistence<Servicio> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ServicioUtil} to access the servicio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the servicio in the entity cache if it is enabled.
    *
    * @param servicio the servicio
    */
    public void cacheResult(ec.gob.snap.vuv.model.Servicio servicio);

    /**
    * Caches the servicios in the entity cache if it is enabled.
    *
    * @param servicios the servicios
    */
    public void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Servicio> servicios);

    /**
    * Creates a new servicio with the primary key. Does not add the servicio to the database.
    *
    * @param id_servicio the primary key for the new servicio
    * @return the new servicio
    */
    public ec.gob.snap.vuv.model.Servicio create(long id_servicio);

    /**
    * Removes the servicio with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio that was removed
    * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Servicio remove(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchServicioException;

    public ec.gob.snap.vuv.model.Servicio updateImpl(
        ec.gob.snap.vuv.model.Servicio servicio)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the servicio with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchServicioException} if it could not be found.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio
    * @throws ec.gob.snap.vuv.NoSuchServicioException if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Servicio findByPrimaryKey(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchServicioException;

    /**
    * Returns the servicio with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_servicio the primary key of the servicio
    * @return the servicio, or <code>null</code> if a servicio with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Servicio fetchByPrimaryKey(long id_servicio)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the servicios.
    *
    * @return the servicios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Servicio> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the servicios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of servicios
    * @param end the upper bound of the range of servicios (not inclusive)
    * @return the range of servicios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Servicio> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the servicios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.ServicioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of servicios
    * @param end the upper bound of the range of servicios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of servicios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Servicio> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the servicios from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of servicios.
    *
    * @return the number of servicios
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
