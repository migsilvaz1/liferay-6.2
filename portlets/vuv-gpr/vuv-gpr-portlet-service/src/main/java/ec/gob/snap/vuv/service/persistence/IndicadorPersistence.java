package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ec.gob.snap.vuv.model.Indicador;

/**
 * The persistence interface for the indicador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndicadorPersistenceImpl
 * @see IndicadorUtil
 * @generated
 */
public interface IndicadorPersistence extends BasePersistence<Indicador> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link IndicadorUtil} to access the indicador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the indicador in the entity cache if it is enabled.
    *
    * @param indicador the indicador
    */
    public void cacheResult(ec.gob.snap.vuv.model.Indicador indicador);

    /**
    * Caches the indicadors in the entity cache if it is enabled.
    *
    * @param indicadors the indicadors
    */
    public void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Indicador> indicadors);

    /**
    * Creates a new indicador with the primary key. Does not add the indicador to the database.
    *
    * @param id_indicador the primary key for the new indicador
    * @return the new indicador
    */
    public ec.gob.snap.vuv.model.Indicador create(long id_indicador);

    /**
    * Removes the indicador with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador that was removed
    * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Indicador remove(long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchIndicadorException;

    public ec.gob.snap.vuv.model.Indicador updateImpl(
        ec.gob.snap.vuv.model.Indicador indicador)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the indicador with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchIndicadorException} if it could not be found.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador
    * @throws ec.gob.snap.vuv.NoSuchIndicadorException if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Indicador findByPrimaryKey(long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchIndicadorException;

    /**
    * Returns the indicador with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_indicador the primary key of the indicador
    * @return the indicador, or <code>null</code> if a indicador with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Indicador fetchByPrimaryKey(long id_indicador)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the indicadors.
    *
    * @return the indicadors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Indicador> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the indicadors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of indicadors
    * @param end the upper bound of the range of indicadors (not inclusive)
    * @return the range of indicadors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Indicador> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the indicadors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.IndicadorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of indicadors
    * @param end the upper bound of the range of indicadors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of indicadors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Indicador> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the indicadors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of indicadors.
    *
    * @return the number of indicadors
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
