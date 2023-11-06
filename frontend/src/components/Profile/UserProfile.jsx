import React from "react";
import { useParams } from "react-router-dom";

const UserProfile = () => {
  const { email } = useParams();

    console.log(email)

  return <div>Profile Section</div>;
};

export default UserProfile;
