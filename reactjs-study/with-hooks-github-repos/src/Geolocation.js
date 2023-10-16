import React, { useEffect, useState } from 'react';

export default function Geolocation() {
    const [location, setLocation] = useState({});

    useEffect(() => {
        const whatchId = navigator.geolocation.watchPosition(handlePositionRecievide)
        
        return () => navigator.geolocation.clearWatch(whatchId);
    }, []);

    function handlePositionRecievide({coords}) {
        const {latitude, longitude} = coords;

        setLocation({latitude, longitude});
    }

    return (
        <>
        Latetude: {location.latitude} {} <br />
        Longetude: {location.longitude}
        </>
    );
}